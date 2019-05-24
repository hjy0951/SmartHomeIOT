package com.example.android.bluetoothchat.data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.example.android.bluetoothchat.ModeActivity;

/**
 * A generic class that holds a result success w/ data or an error exception.
 */
public class Result<T> {
    // hide the private constructor to limit subclass types (Success, Error)
    private Result() {
    }

    @Override
    public String toString() {
        if (this instanceof Result.Success) {
            Result.Success success = (Result.Success) this;
            return "Success[data=" + success.getData().toString() + "]";
        } else if (this instanceof Result.Error) {
            Result.Error error = (Result.Error) this;
            return "Error[exception=" + error.getError().toString() + "]";
        }
        return "";
    }

    // Success sub-class
    public final static class Success<T> extends Result {


        private T data;

        public Success(T data) {
            this.data = data;
//            Intent intent = new Intent(getApplicationContext(), ModeActivity.class);
//        intent.putExtra("fragment", fragment);

//            startActivity(intent);
//        finish();
        }

        public T getData() {
            return this.data;
        }
    }

    // Error sub-class
    public final static class Error extends Result {
        private Exception error;

        public Error(Exception error) {
            this.error = error;
        }

        public Exception getError() {
            return this.error;
        }
    }
}
