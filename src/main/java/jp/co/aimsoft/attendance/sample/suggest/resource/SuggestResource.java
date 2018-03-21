package jp.co.aimsoft.attendance.sample.suggest.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import jp.co.aimsoft.attendance.sample.suggest.model.Campaing;

@RestController
@RequestMapping("api/suggest")
public class SuggestResource {

	private ObjectMapper objectMapper;

	/**
	 * // * tapsuggestのデータを返すだけのテスト<br/>
	 * ajaxテスト用 色々やり方があるから迷っている<br/>
	 * あとでControllerの単位とかは考える。
	 *
	 * @return response
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/getDataFortapSuggestLib", method = RequestMethod.POST)
	public List<List<String>> getJsonDataFortapSuggestLib() throws JsonProcessingException {
		System.out.println("test");
		Campaing cp = new Campaing("001", "aaa", "新キャンペーン", null);
		String cpJsonString = objectMapper.writeValueAsString(cp);
		List<List<String>> dataList = this.createTestData2();
		String dataJson = objectMapper.writeValueAsString(dataList);
		 ObjectReader update = objectMapper.readerForUpdating(cpJsonString);
//		update.
		return createTestData2();
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
