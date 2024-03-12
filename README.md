# movie-api

## About
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

A movie API built with Spring.

## Endpoints
### Movies
```
http://localhost:8080/movies
```
```
{
    "id": 1,
    "name": "Titanic",
    "description": "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.",
    "yearReleased": 1978,
    "imgPath": "https://upload.wikimedia.org/wikipedia/en/1/18/Titanic_%281997_film%29_poster.png",
    "categories": [
      {
        "id": 1,
        "name": "ROMANCE"
      }
    ],
    "actors": [
      {
        "id": 1,
        "name": "Leonardo DiCaprio",
        "age": 52
      }
    ],
    "streamings": [
      {
        "id": 1,
        "name": "Netflix"
      },
      {
        "id": 2,
        "name": "Prime Video"
      }
    ]
}
```
```Java
findById(Long id) // http://localhost:8080/movies/{id}
```
```Java
findByNameIgnoreCaseContains(String name) // http://localhost:8080/movies/search?name={name}
```
```Java
findByYearReleased(Integer yearReleased) // http://localhost:8080/movies/search?year={yearReleased}
```
```Java
findByCategoriesId(Long categoryId) // http://localhost:8080/movies/search?category={categoryId}
```
```Java
findByStreamingsId(Long streamingId) // http://localhost:8080/movies/search?streaming={streamingId}
```
```Java
findByActorsId(Long actorId) // http://localhost:8080/movies/search?actor={actorId}
```
```Java
insert(Movie obj) // http://localhost:8080/movies?{params}
```
### Actors
```
http://localhost:8080/actors
```
```
{
    "id": 1,
    "name": "Leonardo DiCaprio",
    "age": 47
}
```
```Java
findById(Long id) // http://localhost:8080/actors/{id}
```
```Java
findByNameIgnoreCaseContains(String name) // http://localhost:8080/actors/search?name={name}
```
```Java
findByAge(Integer age) // http://localhost:8080/actors/search?age={age}
```
```Java
insert(Actor obj) // http://localhost:8080/actors?{params}
```
### Categories
```
http://localhost:8080/categories
```
```
{
    "id": 1,
    "name": "ROMANCE"
}
```
```Java
findById(Long id) // http://localhost:8080/categories/{id}
```
```Java
insert(Category obj) // http://localhost:8080/categories?{params}
```
### Streamings
```
http://localhost:8080/streamings
```
```
{
    "id": 1,
    "name": "Netflix"
}
```
```Java
findById(Long id) // http://localhost:8080/streamings/{id}
```
```Java
insert(Streamings obj) // http://localhost:8080/streamings?{params}
```
