package dental.appointment.clinic.Activity;

import dagger.internal.Factory;
import dental.appointment.clinic.dynamodb.AppointmentDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class CreateAppointmentActivity_Factory implements Factory<CreateAppointmentActivity> {
  private final Provider<AppointmentDao> appointmentDaoProvider;

  public CreateAppointmentActivity_Factory(Provider<AppointmentDao> appointmentDaoProvider) {
    this.appointmentDaoProvider = appointmentDaoProvider;
  }

  @Override
  public CreateAppointmentActivity get() {
    return new CreateAppointmentActivity(appointmentDaoProvider.get());
  }

  public static CreateAppointmentActivity_Factory create(
      Provider<AppointmentDao> appointmentDaoProvider) {
    return new CreateAppointmentActivity_Factory(appointmentDaoProvider);
  }
}
