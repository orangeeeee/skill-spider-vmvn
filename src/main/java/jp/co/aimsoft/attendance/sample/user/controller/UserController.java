package jp.co.aimsoft.attendance.sample.user.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.aimsoft.attendance.sample.user.model.RequestParams;

/**
 * RestSample Controller 名前をControllerからResourceに変えるべきか
 * 
 * @author y.kurata
 */
@RequestMapping("login")
@RestController
public class UserController {

	/**
	 * 登録用POSTサンプル consumersもutf8が必要か @RequestHeaderのような例をあげていってもいいかもしれない。
	 * 
	 * @return response
	 */
	@RequestMapping(value = "/getTsd", method = RequestMethod.POST)
	public ResponseEntity<String> register(@Valid @RequestBody RequestParams requestParams, BindingResult result,
			@RequestHeader Map<String, String> requestHeader) {

		return ResponseEntity.ok("TODO json params");
	}

	/**
	 * 削除用(DELETE)サンプル consumersもutf8が必要か
	 * 
	 * @return response
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> delete(@Valid @RequestBody RequestParams requestParams) {

		return ResponseEntity.ok("TODO json params");
	}

	/**
	 * 削除用POST(DELETE)サンプル DELETEに対応していないデバイスからのDELETE X-HTTP-Method-Orverride
	 * にて指定する場合 TODO やはり、Spring frameworkではRequestMappingに記載すべき？
	 * JAX-RSでは無いほうがSpringっぽいの？？でもそのほうがすっきりする。
	 * 
	 * @return response
	 */
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST, headers = { "X-HTTP-Method-Orverride=DELETE" })
	public ResponseEntity<String> deletePost(@Valid @RequestBody RequestParams requestParams) {

		return ResponseEntity.ok("TODO json params");
	}
}
