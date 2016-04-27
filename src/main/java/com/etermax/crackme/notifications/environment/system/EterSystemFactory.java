package com.etermax.crackme.notifications.environment.system;

import com.etermax.users.system.EterSystem;

import java.io.IOException;

public interface EterSystemFactory {

	EterSystem createSystem() throws Exception;

}
