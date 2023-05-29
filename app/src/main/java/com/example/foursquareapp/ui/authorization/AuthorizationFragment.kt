package com.example.foursquareapp.ui.authorization

import android.content.Context
import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.foursquareapp.FoursquareApp
import com.example.foursquareapp.R

class AuthorizationFragment : Fragment() {

    private val clientId = "POP01SAZMPCJOB55MSHAFJY0SBW1PHSMOAUGIWNH2OQ0EMWG"
    private val redirectUri = "https://myFoursquareApp.com/redirect"

    private lateinit var webView: WebView

    override fun onAttach(context: Context) {
        (activity?.applicationContext as FoursquareApp).appComponent.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_authorization, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = view.findViewById(R.id.web_view)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = AuthorizationWebViewClient()

        loadAuthorizationPage()
    }

    private fun loadAuthorizationPage() {
        val authUrl = "https://foursquare.com/oauth2/authenticate" +
                "?client_id=$clientId" +
                "&response_type=code" +
                "&redirect_uri=$redirectUri"

        webView.loadUrl(authUrl)
    }

    inner class AuthorizationWebViewClient : WebViewClient() {
        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url = request?.url?.toString()
            if (url != null && url.startsWith(redirectUri)) {
                val code = url.substringAfterLast("code=")
                exchangeCodeForAccessToken(code)
                return true
            }
            return super.shouldOverrideUrlLoading(view, request)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
        }
    }

    fun exchangeCodeForAccessToken(code: String?) {
        val clientId = "YOUR_CLIENT_ID"
        val clientSecret = "YOUR_CLIENT_SECRET"
        val redirectUri = "YOUR_REGISTERED_REDIRECT_URI"
        val tokenUrl = "https://foursquare.com/oauth2/access_token"

        //здесь должен быть вызов метода для получения токена

    }

}
