package dental.appointment.clinic.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class PatientDao_Factory implements Factory<PatientDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public PatientDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public PatientDao get() {
    return new PatientDao(dynamoDbMapperProvider.get());
  }

  public static PatientDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new PatientDao_Factory(dynamoDbMapperProvider);
  }
}
