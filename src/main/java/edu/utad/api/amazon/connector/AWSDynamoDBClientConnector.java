package edu.utad.api.amazon.connector;

import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class AWSDynamoDBClientConnector {

  private AmazonDynamoDBClient dynamoClient;
  private DynamoDBMapper dynamoDBMapper;

  public AWSDynamoDBClientConnector(String acessKey, String secretKey) {
    dynamoClient = new AmazonDynamoDBClient(new BasicAWSCredentials(acessKey, secretKey));
    dynamoClient.setRegion(Region.getRegion(Regions.US_WEST_2));
    dynamoDBMapper = new DynamoDBMapper(dynamoClient);
  }

  public AmazonDynamoDBClient getDynamoClient() {
    return dynamoClient;
  }

  public void setDynamoClient(AmazonDynamoDBClient dynamoClient) {
    this.dynamoClient = dynamoClient;
  }

  public DynamoDBMapper getDynamoDBMapper() {
    return dynamoDBMapper;
  }

  public void setDynamoDBMapper(DynamoDBMapper dynamoDBMapper) {
    this.dynamoDBMapper = dynamoDBMapper;
  }

}
