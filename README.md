Mac OS X Text-To-Speech Web Service
===================================

This is a simple Mac text-to-speech web service, written
with the Play Framework and Scala.


Usage
-----

The _postData.sh_ script shows how to call this web service.
That script looks like this:

    curl \
    --request POST \
    --data "text=hello%20world&voice=Samantha" \
    http://localhost:8080/speak


More information
----------------

For more information, see this URL:

* http://alvinalexander.com/scala/mac-text-to-speech-web-service-play-framework
 

