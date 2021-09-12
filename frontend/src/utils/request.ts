export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';

//?? operador de coalescencia nula que se não retornar do process a variavel de ambiente a esquerda(REACT_app_url) pega da direita (localhost) .