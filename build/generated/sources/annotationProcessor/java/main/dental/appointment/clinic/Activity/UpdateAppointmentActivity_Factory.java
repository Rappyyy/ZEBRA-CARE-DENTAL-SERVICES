package dental.appointment.clinic.Activity;

import dagger.internal.Factory;
import dental.appointment.clinic.dynamodb.AppointmentDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class UpdateAppointmentActivity_Factory implements Factory<UpdateAppointmentActivity> {
  private final Provider<AppointmentDao> appointmentDaoProvider;

  public UpdateAppointmentActivity_Factory(Provider<AppointmentDao> appointmentDaoProvider) {
    this.appointmentDaoProvider = appointmentDaoProvider;
  }

  @Override
  public UpdateAppointmentActivity get() {
    return new UpdateAppointmentActivity(appointmentDaoProvider.get());
  }

  public static UpdateAppointmentActivity_Factory create(
      Provider<AppointmentDao> appointmentDaoProvider) {
    return new UpdateAppointmentActivity_Factory(appointmentDaoProvider);
  }
}
