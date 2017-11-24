package com.lixiaocong.social.qq.api.impl.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.lixiaocong.social.qq.api.QQProfile;

public class QQModule extends SimpleModule {

	public QQModule() {
		super("WeiboModule", new Version(1, 0, 0, null));
	}

	/* (non-Javadoc)
	 * @see org.codehaus.jackson.map.module.SimpleModule#setupModule(org.codehaus.jackson.map.Module.SetupContext)
	 */
	@Override
	public void setupModule(Module.SetupContext context) {
		context.setMixInAnnotations(QQProfile.class, QQProfileMixin.class);
	}

}
