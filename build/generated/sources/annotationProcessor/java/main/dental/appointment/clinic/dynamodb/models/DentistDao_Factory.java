package dental.appointment.clinic.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DentistDao_Factory implements Factory<DentistDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public DentistDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public DentistDao get() {
    return new DentistDao(dynamoDbMapperProvider.get());
  }

  public static DentistDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new DentistDao_Factory(dynamoDbMapperProvider);
  }
}
