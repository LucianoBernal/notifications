package com.etermax.crackme.notifications.environment.initializers;

import com.etermax.apps.service.ApplicationService;
import com.etermax.common.achievement.service.AchievementService;
import com.etermax.common.config.AppConfigProvider;
import com.etermax.common.dao.*;
import com.etermax.common.database.mysql.MySqlExecutor;
import com.etermax.common.dau.statistics.DAUStatisticsService;
import com.etermax.common.facebook.realtime.payments.bootstrap.FacebookPricingBootstrap;
import com.etermax.common.gifting.dao.GiftingDao;
import com.etermax.common.http.RequestReplicatorService;
import com.etermax.common.interfaces.IRequestReplicatorService;
import com.etermax.common.language.service.LanguageService;
import com.etermax.common.language.service.LetterService;
import com.etermax.common.language.service.WordCheckerMap;
import com.etermax.common.messagingpanel.config.MessagingPanelConfigProvider;
import com.etermax.common.messagingpanel.service.MessagingPanelService;
import com.etermax.common.notification.service.BrowserNotifierService;
import com.etermax.common.notification.service.MicrosoftPushNotifierService;
import com.etermax.common.opponentstats.dao.CrossOpponentStatsDao;
import com.etermax.common.opponentstats.service.CrossOpponentStatsService;
import com.etermax.common.provider.CommonProviderEagerInitializer;
import com.etermax.common.security.FacebookAuthenticatorOld;
import com.etermax.common.security.SSLSecurityService;
import com.etermax.common.security.SocialAuthManager;
import com.etermax.common.service.*;
import com.etermax.common.smartplay.TierResolver;
import com.etermax.common.smartplay.dao.SmartTiersDao;
import com.etermax.common.smartplay.service.SmartPlayService;
import com.etermax.common.v2.messaging.ChatDao;
import com.etermax.common.v2.messaging.ChatHeaderDao;
import com.etermax.common.v2.messaging.ChatService;
import com.etermax.common.xnotification.service.NotificationResultsHandler;
import com.etermax.common.xnotification.service.NotificationService;
import com.etermax.common.xnotification.service.NotificationsDailyStatisticsService;

import java.io.IOException;

public class CrackmeCommonModuleInitializer extends CommonProviderEagerInitializer{

	public CrackmeCommonModuleInitializer() throws IOException {
		createAllServices();
		initAllServices();
	}

	private void createAllServices() {
		achievementService = new AchievementService();
		appConfigProvider = new AppConfigProvider();
		mySqlExecutor = new MySqlExecutor();
		dauStatisticsService = new DAUStatisticsService();
		facebookPricingBootstrap = new FacebookPricingBootstrap();
		requestReplicatorService = new RequestReplicatorService();
		languageService = new LanguageService();
		wordCheckerMap = new WordCheckerMap();
		messagingPanelConfigProvider = new MessagingPanelConfigProvider();
		messagingPanelService = new MessagingPanelService();
		microsoftPushNotifierService = new MicrosoftPushNotifierService();
		crossOpponentStatsService = new CrossOpponentStatsService();
		socialAuthManager = new SocialAuthManager();
		facebookAuthenticatorOld = new FacebookAuthenticatorOld();
		sslSecurityService = new SSLSecurityService();
		adminService = new AdminService();
		adsService = new AdsService();
		amazonPurchaseService = new AmazonPurchaseService();
		commonService = new CommonService();
		accessMeanService = new AccessMeanService();
		errorTrackerService = new ErrorTrackerService();
		generalUtilsService = new GeneralUtilsService();
		genericJsonContentService = new GenericJsonContentService();
		inviteService = new InviteService();
		productService = new ProductService();
		requestTrackerService = new RequestTrackerService();
		statsService = new StatsService();
		userAccessService = new UserAccessService();
		userSessionService = new UserSessionService();
		versionService = new VersionService();
		smartPlayService = new SmartPlayService();
		notificationResultsHandler = new NotificationResultsHandler();
		notificationsDailyStatisticsService = new NotificationsDailyStatisticsService();
		notificationService = new NotificationService();
		staticDataService = new StaticDataService();
		applicationService = new ApplicationService();
		letterService = new LetterService();
		chatService = new ChatService();
		chatHeaderDao = new ChatHeaderDao();
		chatDao = new ChatDao();
		smartTierDao = new SmartTiersDao();
		oldUserDao = new OldUserDaoImpl();
		requestTrackerDao = new RequestTrackerDao();
		errorTrackerDao = new ErrorTrackerDao();
		wordDaoImpl = new WordDaoImpl();
		giftingDao = new GiftingDao();
		oldUserService = new OldUserService();
		browserNotifierService = new BrowserNotifierService();
		crossOpponentStatsDao = new CrossOpponentStatsDao();
		achievementDao = new AchievementDao();
		tierResolver = new TierResolver();
	}

	@Override
	protected void initVersionService() throws IOException {

	}

	@Override
	protected void initFacebokPricingBootstrap() throws IOException {

	}

	@Override
	protected void initStaticDataService() {

	}

	@Override
	protected void initRequestReplicatorService() {

	}

	@Override
	protected void initAppConfigProvider() throws IOException {

	}

	@Override
	public IRequestReplicatorService getRequestReplicatorService() {
		return new RequestReplicatorService();
	}

}
