package dental.appointment.clinic.dynamodb;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class AppointmentDao_Factory implements Factory<AppointmentDao> {
  private final Provider<DynamoDBMapper> dynamoDbMapperProvider;

  public AppointmentDao_Factory(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    this.dynamoDbMapperProvider = dynamoDbMapperProvider;
  }

  @Override
  public AppointmentDao get() {
    return new AppointmentDao(dynamoDbMapperProvider.get());
  }

  public static AppointmentDao_Factory create(Provider<DynamoDBMapper> dynamoDbMapperProvider) {
    return new AppointmentDao_Factory(dynamoDbMapperProvider);
  }
}
