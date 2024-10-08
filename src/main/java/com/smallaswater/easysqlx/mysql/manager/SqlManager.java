package com.smallaswater.easysqlx.mysql.manager;


import cn.nukkit.plugin.Plugin;
import com.smallaswater.easysqlx.exceptions.MySqlLoginException;
import com.smallaswater.easysqlx.mysql.utils.UserData;
import com.smallaswater.easysqlx.mysql.BaseMySql;
import org.jetbrains.annotations.NotNull;


/**
 * BaseMySql的实现类
 *
 * @author SmallasWater
 */
public class SqlManager extends BaseMySql {

    private boolean isEnable = false;

    public SqlManager(@NotNull Plugin plugin, @NotNull UserData data) throws MySqlLoginException {
        super(plugin, data);
        if (this.connect()) {
            this.isEnable = true;
        }
    }

    public SqlManager(@NotNull Plugin plugin, @NotNull UserData data, @NotNull String connectionParameters) throws MySqlLoginException {
        super(plugin, data, connectionParameters);
        if (this.connect()) {
            this.isEnable = true;
        }
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void disable() {
        PluginManager.getList().remove(this);
        this.shutdown();
        this.isEnable = false;
    }

}
