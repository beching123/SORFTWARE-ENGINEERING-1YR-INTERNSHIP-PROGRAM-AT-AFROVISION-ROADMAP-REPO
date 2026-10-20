CREATE TABLE AuthorISBN (
	AuthorID 
	ISBN 

	CONSTRAINT fk_authors_authorisbn
		FOREIGN KEY (AuthorID)
		REFERENCES Authors(AuthorID)
		ON DELETE CASCADE,

	CONSTRAINT fk_titles_authorisbn
		FOREIGN KEY (ISBN)
		REFERENCES Titles(ISBN)
		ON DELETE CASCADE
);