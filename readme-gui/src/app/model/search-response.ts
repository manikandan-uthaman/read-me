import { Book } from './book';

export interface SearchResponse {
    books: Array<Book>;
    pageNumber: number;
    totalNumberOfElements: number;
    resultsPerPage: number;
}
