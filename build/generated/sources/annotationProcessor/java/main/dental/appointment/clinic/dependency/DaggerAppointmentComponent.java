package dental.appointment.clinic.dependency;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import dental.appointment.clinic.Activity.CreateAppointmentActivity;
import dental.appointment.clinic.Activity.GetAppointmentActivity;
import dental.appointment.clinic.Activity.UpdateAppointmentActivity;
import dental.appointment.clinic.dynamodb.AppointmentDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class DaggerAppointmentComponent implements AppointmentComponent {
  private Provider<DynamoDBMapper> provideDynamoDBMapperProvider;

  private DaggerAppointmentComponent(Builder builder) {
    initialize(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static AppointmentComponent create() {
    return new Builder().build();
  }

  private AppointmentDao getAppointmentDao() {
    return new AppointmentDao(provideDynamoDBMapperProvider.get());
  }

  @SuppressWarnings("unchecked")
  private void initialize(final Builder builder) {
    this.provideDynamoDBMapperProvider =
        DoubleCheck.provider(DaoModule_ProvideDynamoDBMapperFactory.create(builder.daoModule));
  }

  @Override
  public CreateAppointmentActivity provideCreateAppointmentActivity() {
    return new CreateAppointmentActivity(getAppointmentDao());
  }

  @Override
  public GetAppointmentActivity provideGetAppointmentActivity() {
    return new GetAppointmentActivity(getAppointmentDao());
  }

  @Override
  public UpdateAppointmentActivity provideUpdateAppointmentActivity() {
    return new UpdateAppointmentActivity(getAppointmentDao());
  }

  public static final class Builder {
    private DaoModule daoModule;

    private Builder() {}

    public AppointmentComponent build() {
      if (daoModule == null) {
        this.daoModule = new DaoModule();
      }
      return new DaggerAppointmentComponent(this);
    }

    public Builder daoModule(DaoModule daoModule) {
      this.daoModule = Preconditions.checkNotNull(daoModule);
      return this;
    }
  }
}
