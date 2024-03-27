# Study Software Achitecture Week4
Practice week 4 of Software Achitecture and Design subject <br>
<strong>Content:</strong> Cache with Redis and MySQL in Springboot

# Demo
## First Run: Fetching data from database and save in cache 
http://localhost:8080/api/v1/users/2 <br>
Time query: 120ms
<br>

### Data is saved in cache with key-value userId-userName



## Second Run: Fetching data from cache => Time query reduce
http://localhost:8080/api/v1/users/2 <br>
Time query: 7ms
