# Web Server Log Concepts 💻

The Java programs in this folder, will be able to:

1. Read information from a web server log;

2. Count the number of unique visitors to your website.

3. Count the number of times each visitor uses your website.

### Apache HTTP Server Version 2.4 Concepts
*Referenced from: https://httpd.apache.org/docs/2.4/en/logs.html*

For the programs that have been written in this directory, we have to take in consideration some technical aspects about web server logs, more specifically we will just describe the format in which these are generated and what each part of this log mean.

Lets take as an example the following log entries:

> 127.0.0.1 - frank [10/Oct/2000:13:55:36 -0700] "GET /apache_pb.gif HTTP/1.0" 200 2326 

> 110.76.104.12 - - [30/Sep/2015:07:47:11 -0400] "GET //favicon.ico HTTP/1.1" 200 3246 

* The first is the **IP address**, that is the address of the device on the internet, which made the web request that is logged here.

* The next two pieces are both **dashes** that indicates they are missing information. The first dash is for some information about **who made this request**, which you'll see the documentation says is unreliable. The users computer could lie about who they are. This second dash is for the user name if they're logged in with HTTPF authentication, if they typed in a username and password on the website.

* The next piece of information is the **date and time** when the request was made.

* Next, you have the **request** itself including what type of request it was.
In this case, get, where they're asking for a particular web page and
then what page they asked for.

* Next is the **status**. Here it says, 200, which indicates success.
There are many other statuses, which indicate success or failures, like 404 which is the very well-known status code that indicates that the requested page was not found.

* Finally, is the **number of bytes** that the server replied with.
How much data it sent back to fulfill this request? 
