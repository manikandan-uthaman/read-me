import { Author } from './author';

export interface Book {
    id: number;
    year: string;
    url: string;
    author: Author;
    title: string;
    price: number;
    rating: number;
    description: string;
}