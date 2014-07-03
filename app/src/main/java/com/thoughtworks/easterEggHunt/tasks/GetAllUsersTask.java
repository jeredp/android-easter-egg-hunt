package com.thoughtworks.easterEggHunt.tasks;

import android.os.AsyncTask;
import android.util.Log;
import com.thoughtworks.easterEggHunt.api.RequestCallback;
import com.thoughtworks.easterEggHunt.api.UserService;
import com.thoughtworks.easterEggHunt.domain.User;
import retrofit.RetrofitError;

import java.util.List;

public class GetAllUsersTask extends AsyncTask<Void, Void, Void>{
    private RequestCallback<List<User>> allUsersCallback;
    private UserService userService;

    public GetAllUsersTask(RequestCallback<List<User>> allUsersCallback, UserService userService) {
        this.allUsersCallback = allUsersCallback;
        this.userService = userService;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            List<User> users = userService.users();
            allUsersCallback.success(users);
        } catch (RetrofitError e) {
            Log.e(GetAllUsersTask.class.getName(), "Could not retrieve users", e);
            allUsersCallback.failure(e);
        }
        return null;
    }
}
