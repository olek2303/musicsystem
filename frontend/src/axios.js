import axios from 'axios';

console.log('API URL:', import.meta.env.VITE_API_URL);

const instance = axios.create({
    baseURL: import.meta.env.VITE_API_URL,
    headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json'
    }
});

export default instance;
