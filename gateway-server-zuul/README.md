# Gateway server for Intelligent Routing [for Request form UI]

Here is the endpoint of service **buyer-service** is being called via this Gateway server *(check bootstrap.yml)*.
Example:


`http://localhost:8093/buyer/findAll
`

### Using JWT Token

*Step 1*  - `POST request to http://localhost:8093/auth`
            with
            
    JSON:
     {
          "username": "seller1",
          "password": "123"
     }
    
             
`This will retun a JWT token like : eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU0MTA1NTY1MiwiaWF0IjoxNTQwNDUwODUyfQ.2QCp1ZNXAokmLRl5-UdRw9mr3vqdBPZwLnoBv87OeGT9fqMhtYZTbtAiHITq-yWjCdC-XNwEEJ_Aq-vG_9u3kg`

*Step 2*  - `GET request to http://localhost:8093/buyer/findAll`
     with header
     
     Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTU0MTA1NTY1MiwiaWF0IjoxNTQwNDUwODUyfQ.2QCp1ZNXAokmLRl5-UdRw9mr3vqdBPZwLnoBv87OeGT9fqMhtYZTbtAiHITq-yWjCdC-XNwEEJ_Aq-vG_9u3kg
