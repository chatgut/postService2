<h1>Spring Boot Application - post service</h1>
Application for posting and reading messages<BR>

Application is running on port 8000<BR>
Together with a mongodb instance<BR>
<BR>
<h1>Getting started</h1>
To run in docker containers  via a network called mynetwork:<BR>
docker network create mynetwork<BR>
docker run -p 27017:27017 --name mymongo --network-alias mymongo --network mynetwork -d mongo:latest<BR>
docker run -d --name postservice --network-alias postservice --network mynetwork -p 8000:8000 jonathanjonathan001/postservice:latest<BR>
<BR>
Docker image is available on <BR>
https://hub.docker.com/r/jonathanjonathan001/postservice <BR>
docker pull jonathanjonathan001/postservice:latest
<BR>
<BR>
<h1>Endpoints</h1>

<h2>Endpoint: POST /posts</h2>
JSON format for POST:<BR>
{<BR>
"fromUsername": "kalle",<BR>
"toUsername": "martin",<BR>
"message": "This is a message"<BR>
}<BR>
<BR>
<h2>Endpoint: GET /posts</h2>
To do a GET request the format on the URL should be:<BR>
http://hostname:8000/posts?toUsername=touser&page=0&nMessages=numberofmessages <BR>
<b>And there should be a sender in the http header named userID</b><BR
<b>hostname</b> should be postservice<BR>
<b>touser</b> should be the username of the recipient<BR>
<b>numberofmessages</b> should be the desired number of messages to get<BR>
<BR>
This is the format of the JSON that comes back from the request:<BR>
{<BR>
"id": "645ceefe5423974b37a6d061",<BR>
"fromUsername": "jonathan",<BR>
"toUsername": "martin",<BR>
"message": "This is a message",<BR>
"dateAndTime": "2023-05-11T13:34:54.105117379"<BR>
}<BR>
