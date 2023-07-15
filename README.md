# movie-api

## About
> A movie API built with Spring.

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
```sh
findById(Long id) # http://localhost:8080/movies/{id}
```
```sh
findByNameIgnoreCaseContains(String name) # http://localhost:8080/movies/search?name={name}
```
```sh
findByYearReleased(Integer yearReleased) # http://localhost:8080/movies/search?year={yearReleased}
```
```sh
findByCategoriesId(Long categoryId) # http://localhost:8080/movies/search?category={categoryId}
```
```sh
findByStreamingsId(Long streamingId) # http://localhost:8080/movies/search?streaming={streamingId}
```
```sh
findByActorsId(Long actorId) # http://localhost:8080/movies/search?actor={actorId}
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
```sh
findById(Long id) # http://localhost:8080/actors/{id}
```
```sh
findByNameIgnoreCaseContains(String name) # http://localhost:8080/actors/search?name={name}
```
```sh
findByAge(Integer age) # http://localhost:8080/actors/search?age={age}
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
```sh
findById(Long id) # http://localhost:8080/categories/{id}
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
```sh
findById(Long id) # http://localhost:8080/streamings/{id}
```
