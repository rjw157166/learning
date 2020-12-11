var http=require("http");
var url=require("url");
http.createServer(function (request,response) {

    response.writeHead(200,{"Content-Type":"text/plain"})
    var params=url.parse(request.url,true).query;
    for (var key in params){
        response.write(key+"="+params[key]);
        response.write("\n");
    }
    response.end("");
}).listen(8888);
console.log("start******");