(function(){
    // We'll decide to install our custom output mode under the name 'custom':
    $.validity.outputs.custom = {
    	messages:[],
 		start:function(){ 
        },
        end:function(results) { 
             // If not valid and scrollTo is enabled, scroll the page to the first error.
            results.messages = this.messages;
            return results;
        },
        // Our raise function will display the error and animate the text-box:
        raise:function($obj, msg){
            // Make the JavaScript alert box with the message:
        	this.messages.push(msg);
        },
        // Our aggregate raise will just raise the error on the last input:
        raiseAggregate:function($obj, msg){ 
            this.raise($obj, msg); 
        }
    }
})();