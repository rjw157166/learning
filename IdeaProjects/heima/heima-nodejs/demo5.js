var http=require("http");
http.createServer(function (request,response) {

    response.writeHead(200,{"Content-Type":"text/plain"})
    for (var i=0;i<10;i++){
        response.write("hello word \n");
    }
    response.end("");
}).listen(8888);
console.log("start******");