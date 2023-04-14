package dental.appointment.clinic.lambda;

import dental.appointment.clinic.dependency.AppointmentComponent;
import dental.appointment.clinic.dependency.DaggerAppointmentComponent;
import dental.appointment.clinic.models.requests.CreateAppointmentRequest;
import dental.appointment.clinic.models.results.CreateAppointmentResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class CreateAppointmentActivityProvider implements RequestHandler<CreateAppointmentRequest, CreateAppointmentResult> {

    public CreateAppointmentActivityProvider() {

    }

    @Override
    public CreateAppointmentResult handleRequest(final CreateAppointmentRequest createAppointmentRequest, Context context) {
        return getApp().provideCreateAppointmentActivity().handleRequest(createAppointmentRequest, context);
    }
    private AppointmentComponent getApp() {
        AppointmentComponent dagger = DaggerAppointmentComponent.create();
        return dagger;
    }
}
