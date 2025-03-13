/*
* Support js for Address
*/

function Address(uri_) {
    this.uri = uri_;
}

Address.prototype = {

   getUri : function() {
      return this.uri;
   },
   
   getRemote : function() {
      return new AddressRemote(this.uri);
   }
}

function AddressRemote(uri_) {
    this.uri = uri_+'?expandLevel=1';
}

AddressRemote.prototype = {

   getHtmlXml : function() {
      return rjsSupport.get(this.uri, 'application/xml');
   },

   getHtmlHtml : function() {
      return rjsSupport.get(this.uri, 'text/html');
   },

   putHtmlXml : function(content) {
      return rjsSupport.put(this.uri, 'application/xml', content);
   },

   putHtmlHtml : function(content) {
      return rjsSupport.put(this.uri, 'text/html', content);
   }
}
