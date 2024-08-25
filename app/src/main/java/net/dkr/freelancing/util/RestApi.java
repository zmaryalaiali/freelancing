package net.dkr.freelancing.util;

import net.dkr.freelancing.auth.SignUpResponse;
import net.dkr.freelancing.model.ChatModel;
import net.dkr.freelancing.model.ChatResponse;
import net.dkr.freelancing.model.CreateOrderModel;
import net.dkr.freelancing.model.CreateOrderPostModel;
import net.dkr.freelancing.model.DeliveryWorkModel;
import net.dkr.freelancing.model.GigOrderModel;
import net.dkr.freelancing.model.JobCreateModel;
import net.dkr.freelancing.model.LoginModel;
import net.dkr.freelancing.model.MessageModelA;
import net.dkr.freelancing.model.MessageResponse;
import net.dkr.freelancing.model.NotificationModel;
import net.dkr.freelancing.model.NotificationModelResponse;
import net.dkr.freelancing.model.OrderDetailModel;
import net.dkr.freelancing.model.PaymentModel;
import net.dkr.freelancing.model.PaymentResponse;
import net.dkr.freelancing.model.SignupModel;
import net.dkr.freelancing.model.JobBuyerModel;
import net.dkr.freelancing.model.RecentModel;
import net.dkr.freelancing.model.SearchModel;
import net.dkr.freelancing.model.SingleGigModel;
import net.dkr.freelancing.model.SubmitProposalModel;
import net.dkr.freelancing.model.UserModel;

import org.json.JSONObject;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RestApi {

    @POST("signup")
    Call<SignUpResponse> createUser(@Body SignupModel signupModel);

    @POST("signin")
    Call<SignUpResponse> loginUser(@Body LoginModel loginModel);

    @GET("users/all/gigs")
    Call<RecentModel[]> getGets();

    @GET()
    Call<UserModel> getUser(@Url String url);

    @GET()
    Call<SingleGigModel> getGig(@Url String url);

    @GET()
    Call<RecentModel[]> getGigsBySubCategory(@Url String url);

    @GET("categories")
    Call<SearchModel> getSearch();

    @GET("users/all/jobs")
    Call<JobBuyerModel[]> getJobs(@Header("authorization") String header);

    @Multipart
    @POST("users/{userId}/jobs/{jobId}/proposals/create")
    Call<SubmitProposalModel> submitProposal(@Header("authorization") String header,
                                    @Path("userId") String userId,
                                    @Path("jobId") String jobId,
                                    @Part MultipartBody.Part image,
                                    @Part("link") RequestBody link,
                                    @Part("coverLetter") RequestBody coverLetter);

    @POST("users/{id}/jobs/create")
    Call<JobBuyerModel> CreateJob(@Header("authorization") String header,
                                  @Path("id") String id
            , @Body JobCreateModel model);


    @GET()
    Call<GigOrderModel[]> orderManagement(@Header("authorization") String header,
                                          @Url String url);
    @GET()
    Call<OrderDetailModel> getOrder(@Header("authorization") String header,
                                    @Url String url);

    @POST("chat")
    Call<ChatResponse> createChat(@Body ChatModel chatModel);

    @GET()
    Call<ChatResponse> getChat(@Url String url);

    @GET("chat/{id}")
    Call<ChatResponse[]> getChats(@Path("id") String id);

    @POST("message/{chatId}")
    Call<MessageResponse> message(@Body MessageModelA messageModelA,@Path("chatId") String id);

    @GET()
    Call<MessageResponse[]> getMessages(@Url String url);

    @POST()
    Call<CreateOrderModel> createOrder(@Header("authorization") String header,
                                           @Url String url,
                                             @Body CreateOrderPostModel gigId);

    @POST("payments/checkout")
    Call<PaymentResponse> payment(@Header("authorization") String header,
                                  @Body PaymentModel model);

    @POST("notifications/create")
    Call<NotificationModelResponse> createNotification(@Body NotificationModel notificationModel);

    @Multipart
    @PATCH("users/{userId}/manageOrders/{orderId}/deliver")
    Call<String> delivery(@Header("authorization") String header,
                                     @Path("userId") String userId,
                                     @Path("orderId") String orderId,
                                     @Part MultipartBody.Part file,
                                     @Part("description") RequestBody description);
}
