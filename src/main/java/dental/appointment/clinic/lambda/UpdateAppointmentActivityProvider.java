package dental.appointment.clinic.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dental.appointment.clinic.dependency.AppointmentComponent;
import dental.appointment.clinic.dependency.DaggerAppointmentComponent;
import dental.appointment.clinic.models.requests.UpdateAppointmentRequest;
import dental.appointment.clinic.models.results.UpdateAppointmentResult;

public class UpdateAppointmentActivityProvider implements RequestHandler <UpdateAppointmentRequest, UpdateAppointmentResult> {

    public UpdateAppointmentActivityProvider() {

    }
    @Override
    public UpdateAppointmentResult handleRequest(UpdateAppointmentRequest updateAppointmentRequest, Context context) {
        return getApp().provideUpdateAppointmentActivity().handleRequest(updateAppointmentRequest,context);
    }

    private AppointmentComponent getApp() {
        AppointmentComponent dagger = DaggerAppointmentComponent.create();
        return dagger;
    }
}
