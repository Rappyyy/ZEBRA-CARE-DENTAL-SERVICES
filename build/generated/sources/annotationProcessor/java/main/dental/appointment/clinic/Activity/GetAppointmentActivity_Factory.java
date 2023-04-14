package dental.appointment.clinic.Activity;

import dagger.internal.Factory;
import dental.appointment.clinic.dynamodb.AppointmentDao;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class GetAppointmentActivity_Factory implements Factory<GetAppointmentActivity> {
  private final Provider<AppointmentDao> appointmentDaoProvider;

  public GetAppointmentActivity_Factory(Provider<AppointmentDao> appointmentDaoProvider) {
    this.appointmentDaoProvider = appointmentDaoProvider;
  }

  @Override
  public GetAppointmentActivity get() {
    return new GetAppointmentActivity(appointmentDaoProvider.get());
  }

  public static GetAppointmentActivity_Factory create(
      Provider<AppointmentDao> appointmentDaoProvider) {
    return new GetAppointmentActivity_Factory(appointmentDaoProvider);
  }
}
