package io.github.esabook.hyperion_chucker;

import com.google.auto.service.AutoService;
import com.willowtreeapps.hyperion.plugin.v1.Plugin;
import com.willowtreeapps.hyperion.plugin.v1.PluginModule;

import io.github.esabook.hyperion_chucker.ChuckModule;

@SuppressWarnings("unused")
@AutoService(Plugin.class)
public class ChuckPlugin extends Plugin {

    @Override
    public PluginModule createPluginModule() {
        return new ChuckModule();
    }

}
