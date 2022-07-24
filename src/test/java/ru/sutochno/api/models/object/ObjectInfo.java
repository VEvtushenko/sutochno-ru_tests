package ru.sutochno.api.models.object;

import java.util.List;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectInfo{

	private boolean success;

	@lombok.Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Data{
		@lombok.Data
		@JsonIgnoreProperties(ignoreUnknown = true)
		public class Object{
			private int id;
			@JsonProperty("status_id")
			private int statusId;
			@JsonProperty("status_title")
			private String statusTitle;
			private boolean visible;
			@JsonProperty("date_add")
			private String dateAdd;
			@JsonProperty("date_update")
			private String dateUpdate;
			@JsonProperty("date_actual")
			private String dateActual;
			private String url;
			private String title;
			@JsonProperty("type_title")
			private String typeTitle;

			@lombok.Data
			@JsonIgnoreProperties(ignoreUnknown = true)
			public class Properties{


				@lombok.Data
				public class CheckInOutRules{
					private String title;
					private List<PropertiesItem> properties;
				}
				@JsonProperty("check_in_out_rules")
				private CheckInOutRules checkInOutRules;

				@lombok.Data
				public class BasicProperties{
					private String title;
					private List<PropertiesItem> properties;
				}
				@JsonProperty("basic_properties")
				private BasicProperties basicProperties;

				@lombok.Data
				public class EnterName{
					private String title;
					private List<PropertiesItem> properties;
				}
				@JsonProperty("enter_name")
				private EnterName enterName;

				@lombok.Data
				public class AdditionalProperties{
					private String title;
					private List<PropertiesItem> properties;
				}
				@JsonProperty("additional_properties")
				private AdditionalProperties additionalProperties;

				@lombok.Data
				public class Availability{
					private String title;
					private List<PropertiesItem> properties;
				}
				private Availability availability;

				@lombok.Data
				public class Equipment{
					private String title;
					private List<PropertiesItem> properties;
				}
				private Equipment equipment;
			}
			private Properties properties;

			@lombok.Data
			@JsonIgnoreProperties(ignoreUnknown = true)
			public class Location{
				private String address;
				private String location;
				private String place;
				private String lat;
				private String lng;
				private String seas;
			}
			private Location location;

			private List<String> media;
			@JsonProperty("current_price")
			private Integer currentPrice;

			@lombok.Data
			public class ExtpricesItem{
				private int value;
				@JsonProperty("currency_id")
				private int currencyId;
				private String interval;
				@JsonProperty("interval_start")
				private int intervalStart;
				@JsonProperty("price_per_person")
				private int pricePerPerson;
				@JsonProperty("included_persons")
				private int  includedPersons;
			}
			private List<ExtpricesItem> extprices;

			private boolean favorite;
			@JsonProperty("is_hot")
			private boolean isHot;
			@JsonProperty("hot_price")
			private int hotPrice;
			@JsonProperty("hot_sale")
			private String hotSale;
			@JsonProperty("hot_time")
			private String hotTime;
			@JsonProperty("short_description")
			private String shortDescription;
			@JsonProperty("is_popular")
			private int isPopular;
			@JsonProperty("is_complete")
			private boolean isComplete;
			private String status;
			private String meal;

			@lombok.Data
			public class ExternalReviewsItem{
				private int rating;
				private int count;
			}
			@JsonProperty("external_reviews")
			private List<ExternalReviewsItem> externalReviews;

			@lombok.Data
			public class Owner{
				private int id;
				private String name;
				private String company;
				private int gender;
				private String avatar;
				@JsonProperty("date_add")
				private String dateAdd;
				@JsonProperty("date_last_login")
				private String dateLastLogin;
				@JsonProperty("answer_rate")
				private int answerRate;
				@JsonProperty("answer_time")
				private int answerTime;
				@JsonProperty("date_is_newby")
				private int dateIsNewby;
				@JsonProperty("is_newby")
				private boolean isNewby;
				private List<String> permissions;
				@JsonProperty("speak_languages")
				private List<String> speakLanguages;
				private List<String > contacts;
			}
			private Owner owner;

			private int position;
			private int pr;
		}
		private Object object;

		@lombok.Data
		public class Reviews {
			private int count;
			private List<String> list;
		}
		private Reviews reviews;

		private List<String> calendar;

	}
	private Data data;

	private List<String> errors;

	@lombok.Data
	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Actions{
		private boolean showObject;
	}
	private Actions actions;

	private String platform;
	private String uuid;
	private int timestamp;
}