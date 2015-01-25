
var AWS = require('aws-sdk');
AWS.config.region = 'us-west-2';
AWS.config.update({accessKeyId: 'FAKE', secretAccessKey: 'FAKE'});

var db = new AWS.DynamoDB();

exports.handler = function(event, context) {
    
    
    var paramsGet = {
    TableName : 'PabloGranadosCinemaSeats',
    Key : { 
      "Id" : {
        "S" : event.seatId
      },
    }
  }

  db.getItem(paramsGet, function(err, dataResponse) {
    if (err) {
      console.log(err); // an error occurred
      } 
    else {
      console.log(dataResponse); // successful response
      console.log("Eco " + dataResponse.Item.status.S);
      dataResponse.Item.status.S = "ocupated";
          
     var paramsPut = {
     TableName : 'PabloGranadosCinemaSeats',
     Item : {
         "Id" : {"S" : dataResponse.Item.Id.S},
         "row": {"N" : dataResponse.Item.row.N},
         "col": {"N" : dataResponse.Item.col.N},
         "ownerName": {"S" : dataResponse.Item.ownerName.S},
         "createdAt": {"N" : dataResponse.Item.createdAt.N},
         "updatedAt": {"N" : dataResponse.Item.updatedAt.N},
         "version": {"N" : dataResponse.Item.version.N},
         "roomName": {"S" : dataResponse.Item.roomName.S},
         "status": {"S" : "occupied"},
      }
     };
      
      db.putItem(paramsPut, new function(err, data) {
        if (err){
            console.log("error");
            console.log(err, err.stack); // an error occurred
        }else{
            console.log(data);           // successful response
        }
     });
    }
  });
  

}

