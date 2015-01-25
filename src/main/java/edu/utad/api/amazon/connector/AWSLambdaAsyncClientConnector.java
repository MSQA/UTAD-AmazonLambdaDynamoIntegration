package edu.utad.api.amazon.connector;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambdaAsyncClient;

public class AWSLambdaAsyncClientConnector {

  private AWSLambdaAsyncClient lamdba;
  
  public AWSLambdaAsyncClientConnector(String acessKey, String secretKey){
    
    lamdba = new AWSLambdaAsyncClient(new BasicAWSCredentials(acessKey, secretKey));
    lamdba.setRegion(Region.getRegion(Regions.US_WEST_2));
  }

  public AWSLambdaAsyncClient getLamdba() {
    return lamdba;
  }

  public void setLamdba(AWSLambdaAsyncClient lamdba) {
    this.lamdba = lamdba;
  }
  
}
