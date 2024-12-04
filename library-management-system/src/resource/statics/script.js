
// script.js

let books = [];

const bookForm = document.getElementById("bookForm");
const bookTitle = document.getElementById("bookTitle");
const bookAuthor = document.getElementById("bookAuthor");
const bookList = document.getElementById("books");
const searchBar = document.getElementById("searchBar");

bookForm.addEventListener("submit", function (e) {
  e.preventDefault();

  const title = bookTitle.value.trim();
  const author = bookAuthor.value.trim();

  if (title && author) {
    const newBook = { title, author };
    books.push(newBook);
    renderBooks();
    bookTitle.value = "";
    bookAuthor.value = "";
  }
});

function renderBooks() {
  bookList.innerHTML = "";
  books.forEach((book, index) => {
    const bookItem = document.createElement("li");
    bookItem.innerHTML = `
      <span><strong>${book.title}</strong> by ${book.author}</span>
      <button onclick="deleteBook(${index})">Delete</button>
    `;
    bookList.appendChild(bookItem);
  });
}

function deleteBook(index) {
  books.splice(index, 1);
  renderBooks();
}

function searchBook() {
  const searchText = searchBar.value.toLowerCase();
  const filteredBooks = books.filter(book => 
    book.title.toLowerCase().includes(searchText) || 
    book.author.toLowerCase().includes(searchText)
  );
  renderFilteredBooks(filteredBooks);
}

function renderFilteredBooks(filteredBooks) {
  bookList.innerHTML = "";
  filteredBooks.forEach((book, index) => {
    const bookItem = document.createElement("li");
    bookItem.innerHTML = `
      <span><strong>${book.title}</strong> by ${book.author}</span>
      <button onclick="deleteBook(${index})">Delete</button>
    `;
    bookList.appendChild(bookItem);
  });
}
