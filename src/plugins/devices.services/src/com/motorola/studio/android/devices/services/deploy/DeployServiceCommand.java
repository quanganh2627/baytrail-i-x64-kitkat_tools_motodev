/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.motorola.studio.android.devices.services.deploy;

import java.util.Arrays;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.sequoyah.device.common.utilities.exception.SequoyahException;
import org.eclipse.sequoyah.device.framework.manager.ServiceManager;
import org.eclipse.sequoyah.device.framework.model.IInstance;

import com.motorola.studio.android.devices.services.DeviceServicesPlugin;
import com.motorola.studio.android.emulator.core.model.IAndroidEmulatorInstance;
import com.motorola.studio.android.emulator.ui.view.AbstractAndroidView;

public class DeployServiceCommand extends AbstractHandler
{

    public Object execute(ExecutionEvent event) throws ExecutionException
    {
        IAndroidEmulatorInstance emulatorInstance = AbstractAndroidView.getActiveInstance();
        if (emulatorInstance instanceof IInstance)
        {
            try
            {
                IInstance instance = (IInstance) emulatorInstance;

                ServiceManager.runServices(Arrays.asList(instance),
                        DeviceServicesPlugin.DEPLOY_SERVICE_ID);
            }
            catch (SequoyahException e)
            {
                //do nothing
            }
        }
        return null;
    }

}
