package jp.co.aimsoft.attendance.sample.suggest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jp.co.aimsoft.attendance.sample.suggest.model.Campaing;
import jp.co.aimsoft.attendance.sample.suggest.model.LoginParameter;
import jp.co.aimsoft.attendance.sample.suggest.model.UserNameKeyAssist;

@Controller
public class SampleController {

	@Autowired
	private ObjectMapper objectMapper;

	/** コンストラクタ. */
	public SampleController() {

	}

	/**
	 * 初期表示.
	 *
	 * @return response
	 */
	@RequestMapping("/tapsuggestSample")
	public ModelAndView tapsuggestSample() {

		ModelAndView viewable = new ModelAndView();
		viewable.setViewName("sample/tapsuggest");

		return viewable;
	}

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 *
	 * @return response
	 */
	@ResponseBody
	@RequestMapping(value = "/getDataFortapSuggestLib", method = RequestMethod.POST)
	public List<UserNameKeyAssist> getJsonDataFortapSuggestLib(HttpSession session) {

		System.out.println(session.getAttribute("testSessionParameter"));

		return this.createTestData();
	}

	@ResponseBody
	@RequestMapping(value = "/getTsd", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<String> getTestData(@RequestBody LoginParameter loginParameter, HttpSession session)
			throws JsonProcessingException {
		System.out.println("test");
		Campaing cp = new Campaing("xere23l2lmga92","001", "aaa", "新キャンペーン");
		String cpJsonString = objectMapper.writeValueAsString(cp);

		session.setAttribute("testSessionParameter", "logined");

		return ResponseEntity.ok(cpJsonString);
	}

	@ResponseBody
	@RequestMapping(value = "/getLLL", method = RequestMethod.PUT, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<String> getTestData(HttpSession session) throws JsonProcessingException {
		System.out.println("test");
		Campaing cp = new Campaing("xere23l2lmga92","001", "aaa", "新キャンペーン");
		String cpJsonString = objectMapper.writeValueAsString(cp);

		JsonObject json = Json.parse(cpJsonString).asObject();
		String id = json.get("id").asString();
		String kind = json.get("kind").asString();

		System.out.println("id:" + id + ",kind:" + kind);
		System.out.println(session.getAttribute("testSessionParameter"));
		boolean isError = false;
		StringBuilder errorDetails = new StringBuilder();


		if (!"001".equals(id)) {
		    errorDetails.append("idが想定値[");
		    errorDetails.append(id);
		    errorDetails.append("]ではありませんでした。\n\r");
		    isError = true;
		}
		if (!"A001".equals(kind)) {

		    errorDetails.append("kindが想定値[");
		    errorDetails.append(kind);
		    errorDetails.append("]ではありませんでした。\n\r");
		    isError = true;
		}

		return ResponseEntity.ok(cpJsonString);
	}

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 *
	 * @return response
	 */
	@ResponseBody
	@RequestMapping(value = "/getDataFortapSuggestLib2", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_UTF8_VALUE })
	public List<List<String>> getJsonDataFortapSuggestLib2() {
		return this.createTestData2();
	}

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 *
	 * @return response
	 */
	@ResponseBody
	@RequestMapping(value = "/getDataFortapSuggestLib1", method = RequestMethod.POST)
	public String getJsonDataFortapSuggestLib1() {

		ObjectMapper mapper = new ObjectMapper();

		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(this.createTestData());
			System.out.println("jsonString:" + jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// chromeのコンソールにて文字化けしている。
		// 文字コードをutf8にしなければいけない・・・設定が必要。
		return jsonString;
	}

	private List<UserNameKeyAssist> createTestData() {
		List<UserNameKeyAssist> list = new ArrayList<>();
		list.add(new UserNameKeyAssist("倉田", "kurata", "クラタ", "くらた"));
		list.add(new UserNameKeyAssist("岩井", "iwai", "イワイ", "いわい"));
		list.add(new UserNameKeyAssist("高橋", "takahashi", "タカハシ", "たかはし"));
		return list;
	}

	private List<List<String>> createTestData2() {
		List<List<String>> lists = new ArrayList<>();
		lists.add(Arrays.asList("倉田", "kurata", "クラタ", "くらた"));
		lists.add(Arrays.asList("岩井", "iwai", "イワイ", "いわい"));
		lists.add(Arrays.asList("高橋", "takahashi", "タカハシ", "たかはし"));
		lists.add(Arrays.asList("佐藤", "sato", "サトウ", "さとう"));
		lists.add(Arrays.asList("伊藤", "ito", "イトウ", "いとう"));
		return lists;
	}
}
