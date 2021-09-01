package com.ilagoproject.myapplication.viewmodel

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.ilagoproject.myapplication.R
import com.ilagoproject.myapplication.databinding.FragmentAuthorizationBinding
import com.ilagoproject.myapplication.model.data.AccountData
import com.ilagoproject.myapplication.service.Authorization
import com.ilagoproject.myapplication.service.RandomAuthorization
import com.ilagoproject.myapplication.service.error.Disconnect
import com.ilagoproject.myapplication.utils.isOnline
import com.ilagoproject.myapplication.utils.markAsRequired
import com.ilagoproject.myapplication.viewmodel.base.AppViewModelFragment
import es.dmoral.toasty.Toasty
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_authorization.*

class AuthorizationFragment : AppViewModelFragment() {

    lateinit var authorization: Authorization

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        authorization = RandomAuthorization(context!!)
    }

    fun signIn(){
        if(context!!.isOnline().not()){
            Toasty.error(context!!, R.string.no_internet_access, Toasty.LENGTH_LONG).show()
            return
        }

        if(login.text?.isEmpty() == true){
            login.markAsRequired()
            return
        }

        if(password.text?.isEmpty() == true){
            password.markAsRequired()
            return
        }

        startSignIn()

        val login = login.text.toString()
        val password = password.text.toString()

        model.accountData = AccountData(login, password)

        signIn(login, password)
    }

    private fun signIn(login: String, password: String){
        val auth = authorization
            .setAccountData(AccountData(login, password))
            .startAuthorization()

        auth
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onAuthorizationEnd, this::onSignInError)

    }

    private fun onAuthorizationEnd(success: Boolean){
        if(success){
            if(model.isRememberMe)
                model.saveData()
            goToPage(R.id.action_authorizationFragment_to_infoFragment)
        }
        else{
            endSignIn()
            Toasty.error(context!!, getString(R.string.wrong_auth_data), Toast.LENGTH_LONG).show()
        }
    }

    fun onCheckedRememberMe(){
        model.setIsRemember(rememberMe.isChecked)
    }

    private fun startSignIn(){
        progressIndicatorAuthorization.show()
        rememberMe.visibility = View.GONE
        signInBtn.visibility = View.GONE
    }

    private fun endSignIn(){
        progressIndicatorAuthorization.hide()
        rememberMe.visibility = View.VISIBLE
        signInBtn.visibility = View.VISIBLE
    }

    private fun onSignInError(throwable: Throwable?){
        endSignIn()
        if(throwable is Disconnect){
            Toasty.error(context!!, getString(R.string.no_internet_access), Toast.LENGTH_LONG).show()
        }
        else {
            Toasty.error(context!!, getString(R.string.wrong_auth_data), Toast.LENGTH_LONG).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if(model.isAuthSaved){
            goToPage(R.id.action_authorizationFragment_to_infoFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAuthorizationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_authorization, container, false)
        binding.viewModel = this
        return binding.root
    }
}