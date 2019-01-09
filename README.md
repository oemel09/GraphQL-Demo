# GraphQL-Demo
A demo project for GraphQL taken from here:  
https://www.pluralsight.com/guides/building-a-graphql-server-with-spring-boot

Just to learn about GraphQL. I didn't implement the error handling yet, as I want to focus only on the minimal basics of GraphQL for now.

You can use GraphiQL to send queries  
`http://localhost:8080/graphiql`

Try these samples to query the api:  
```
findAllBooks {
   id
   title
 }
```

```
{
  findAllBooks {
    id
    isbn
    title
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

To create, update or delete entries use `mutation`
```
mutation {
  newAuthor(
    firstName: "Demo"
    lastName: "Author"
  ) {
    id firstName lastName
  }
}
```
```
mutation {
  newBook(
    title: "Demo Book"
    isbn: "0123456789"
    pageCount: 123
    author: 8
  ) {
    id title author {
      firstName lastName
    }
  }
}
```
