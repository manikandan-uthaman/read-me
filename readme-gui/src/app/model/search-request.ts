export enum FilterCriteria {
    TITLE = 'TITLE',
    AUTHOR = 'AUTHOR'
}

export interface BookSearchRequest {
    filterCriteria?: FilterCriteria;
    searchString?: string;
    pageNumber?: number; // starts with 1
    recordsPerPage?: number;
}