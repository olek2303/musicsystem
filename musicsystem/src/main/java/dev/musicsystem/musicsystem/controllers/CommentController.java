package dev.musicsystem.musicsystem.controllers;

import dev.musicsystem.musicsystem.entity.Album;
import dev.musicsystem.musicsystem.entity.Comment;
import dev.musicsystem.musicsystem.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/all")
    public List<Comment> getAllComments() { return commentService.AllComments();}

    @PostMapping(value = "", name="addComment")
    public ResponseEntity<Comment> addComment(@RequestBody Comment comment) {
        if (commentService.commentExists(comment)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Comment savedComment = commentService.saveComment(comment);

        if (savedComment == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment updatedComment) {
        Comment existingComment = commentService.commentById(commentId);

        if (existingComment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updatedComment.setCommentId(commentId);

        Comment savedComment = commentService.saveComment(updatedComment);

        if (savedComment == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(savedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        Comment existingComment = commentService.commentById(commentId);

        if (existingComment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            commentService.deleteComment(commentId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
