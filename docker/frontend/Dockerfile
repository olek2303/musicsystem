FROM node:lts-alpine as build-stage
WORKDIR /app
COPY frontend/package*.json ./
COPY frontend/.env .env
RUN npm install
COPY frontend/ .
RUN npm run build

FROM nginx:stable-alpine
COPY frontend/nginx.conf /etc/nginx/nginx.conf
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]