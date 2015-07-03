package com.example.same_location;

import com.example.same_location.staticdata.CityName;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;


/**
 * 
 * @author yui
 *
 */
public class CityChangeActivity extends Activity {
	
	
	
	private Button btnClose;
	private AutoCompleteTextView autoTextView;
	private ArrayAdapter<String> arrayAdapter;
	private String[] normalString = new String[] { "北京市", "天津市", "上海市 ",
			"重庆市 ", "沈阳市", "大连市", "鞍山市", "抚顺市", "本溪市", "丹东市", "锦州市", "葫芦岛市",
			"营口市", "盘锦市", "阜新市", "辽阳市", "铁岭市", "朝阳市", "凌源市", "北票市", "长春市",
			"吉林市", "四平市", "辽源市", "通化市", "白山市", "延边朝鲜族自治州", "白城市", "松原市",
			"哈尔滨市", "齐齐哈尔市", "鹤岗市", "双鸭山市", "鸡西市", "大庆市", "伊春市", "牡丹江市",
			"佳木斯市", "台河市", "黑河市", "绥化市", "大兴安岭地区", "石家庄市", "唐山市", "秦皇岛市",
			"邯郸市", "邢台市", "保定市", "张家口市", "承德市", "廊坊市", "衡水市", "沧州市", "太原市",
			"大同市", "阳泉市", "长治市", "晋城市", "朔州市", "晋中市", "运城市", "忻州市", "临汾市",
			"吕梁地区", "郑州市", "开封市", "洛阳市", "平顶山市", "焦作市", "鹤壁市", "新乡市", "安阳市",
			"濮阳市", "许昌市", "漯河市", "三门峡市", "南阳市", "商丘市", "信阳市", "周口市", "驻马店市",
			"济源市", "济南市", "青岛市", "淄博市", "枣庄市", "东营市", "潍坊市", "烟台市", "威海市",
			"济宁市", "泰安市", "日照市", "莱芜市", "临沂市", "德州市", "聊城市", "滨州市", "菏泽市",
			"南京市", "徐州市", "连云港市", "淮安市", "宿迁市", "盐城市", "扬州市", "泰州市", "南通市",
			"镇江市", "常州市", "无锡市", "苏州市", "合肥市", "芜湖市", "蚌埠市", "淮南市", "马鞍山市",
			"淮北市", "铜陵市", "安庆市", "黄山市", "滁州市", "阜阳市", "宿州市", "巢湖市", "六安市",
			"亳州市", "池州市", "宣城市", "南昌市", "萍乡市", "九江市", "新余市", "鹰潭市", "赣州市",
			"吉安市", "宜春市", "抚州市", "上饶市", "杭州市", "宁波市", "温州市", "嘉兴市", "绍兴市",
			"金华市", "衢州市", "舟山市", "台州市", "丽水市", "福州市", "厦门市", "三明市", "莆田市",
			"泉州市", "漳州市", "南平市", "龙岩市", "宁德市", "广州市", "深圳市", "珠海市", "汕头市",
			"韶关市", "惠州市", "河源市", "梅州市", "汕尾市", "东莞市", "中山市", "江门市", "佛山市",
			"阳江市", "湛江市", "茂名市", "肇庆市", "清远市", "潮州市", "揭阳市", "云浮市", "海口市",
			"三亚市", "台北市", "高雄市", "基隆市", "台中市", "台南市", "新竹市", "板桥市", "宜兰市",
			"竹北市", "桃园市", "苗栗市", "丰原市", "彰化市", "南投市", "太保市", " 斗六市", "新营市",
			" 凤山市", "屏东市", "台东市", "花莲市", "马公市", "贵阳市", "六盘水市", "遵义市", "安顺市",
			"铜仁地区", "毕节地区", "黔西南布依族苗族自治州", "黔东南南苗族侗族自治州", "黔南布依族苗族自治州", "昆明市",
			"玉溪市", "保山市", "昭通市", "思茅地区", "临沧地区", "丽江地区", "文山壮族苗族自治州",
			"红河哈尼族彝族自治州", "西双版纳傣族自治州", "楚雄彝族自治州", "大理白族自治州", "德宏傣族景颇族自治州",
			"怒江傈僳族自治州", "迪庆藏族自治州", "成都市", "自贡市", "攀枝花市", "泸州市", "德阳市", "绵阳市",
			"广元市", "遂宁市", "内江市", "乐山市", "南充市", "宜宾市", "广安市", "达州市", "眉山市",
			"雅安市", "巴中市", "资阳市", "阿坝藏族羌族自治州", "甘孜藏族自治州", "凉山彝族自治州", "长沙市",
			"株洲市", "湘潭市", "衡阳市", "邵阳市", "岳阳市", "常德市", "张家界市", "益阳市", "郴州市",
			"永市", "怀化市", "娄底市", "湘西土家族苗族自治州", "武汉市", "黄石市", "襄樊市", "十堰市",
			"荆州市", "宜昌市", "荆门市", "鄂州市", "孝感市", "黄冈市", "咸宁市", "随州市",
			"恩施土家族苗族自治州", "仙桃市", "天门市", "潜江市", "神农架林区", "西安市", "铜川市", "宝鸡市",
			"咸阳市", "渭南市", "延安市", "汉中市", "榆林市", "安康市", "商洛市", "兰州市", "金昌市",
			"白银市", "天水市", "嘉峪关市", "武威市", "张掖市", "平凉市", "酒泉市", "庆阳市", "定西地区",
			"陇南地区", "甘南藏族自治州", "临夏回族自治州", "西宁市", "海东地区", "海北藏族自治州", "黄南藏族自治州",
			"海南藏族自治州", "果洛藏族自治州", "玉树藏族自治州", "海西蒙古族藏族自治州", "呼和浩特市", "包头市",
			"乌海市", "赤峰市", "鄂尔多斯市", "呼伦贝尔市", "乌兰察布盟", "锡林郭勒盟", "巴彦淖尔盟", "阿拉善盟",
			"兴安盟", "拉萨市", "昌都地区", "山南地区", "日喀则地区", "阿里地区", "林芝地区", "乌鲁木齐市",
			"克拉玛依市", "吐鲁番地区", "哈密地区", "和田地区", "阿克苏地区", "喀什地区", "克孜勒苏柯尔克孜自治州",
			"巴音郭楞州", "昌吉州", "博尔塔拉州", "伊犁哈萨克自治州", "塔城地区", "阿勒泰州", "石河子市",
			"阿拉尔市", "图木舒克市", "五家渠市", "南宁市", "柳州市", "桂林市", "梧州市", "北海市", "防城港市",
			"钦州市", "贵港市", "玉林市", "百色市", "贺州市", "河池市", "来宾市", "崇左市", "银川市",
			"石嘴山市", "吴忠市", "固原市" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autocomplete_index);
		autoTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		arrayAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, normalString);
		autoTextView.setAdapter(arrayAdapter);
		btnClose = (Button) findViewById(R.id.confirm);
		btnClose.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				CityName.CITYNAME=autoTextView.getText().toString();
				Intent intent = new Intent();
				intent.putExtra("result", autoTextView.getText().toString());
                setResult(15, intent);// 设置resultCode，onActivityResult()中能获取到
                finish();
				//System.out.println(CityName.CITYNAME);
				//System.out.println(autoTextView.getText().toString());
				finish();
			}
		});
	}

	
}
