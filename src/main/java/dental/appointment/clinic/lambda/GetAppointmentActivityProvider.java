package dental.appointment.clinic.lambda;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import dental.appointment.clinic.dependency.AppointmentComponent;
import dental.appointment.clinic.dependency.DaggerAppointmentComponent;
import dental.appointment.clinic.models.requests.GetAppointmentRequest;
import dental.appointment.clinic.models.results.GetAppointmentResult;

public class GetAppointmentActivityProvider implements RequestHandler <GetAppointmentRequest, GetAppointmentResult> {

    public GetAppointmentActivityProvider() {

    }

    @Override
    public GetAppointmentResult handleRequest(GetAppointmentRequest getAppointmentRequest, Context context) {
        return getApp().provideGetAppointmentActivity().handleRequest(getAppointmentRequest, context);
    }
    private AppointmentComponent getApp() {
        AppointmentComponent dagger = DaggerAppointmentComponent.create();
        return dagger;
    }
}
