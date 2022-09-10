package com.kob.backend.service.impl.user.bot;

import com.kob.backend.mapper.BotMapper;
import com.kob.backend.pojo.Bot;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.bot.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Wei
 * @version 1.0
 * @Description TODO
 */

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    private BotMapper botMapper;
    @Override
    public Map<String, String> update(Map<String, String> data) {
        UsernamePasswordAuthenticationToken authenticationToken =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        int bot_id = Integer.parseInt(data.get("bot_id"));
        String title = data.get("title");
        String description = data.get("description");
        String content = data.get("content");

        Map<String, String> map = new HashMap<>();

        if (title == null || title.length() == 0) {
            map.put("error_message", "Title cannot be empty");
            return map;
        }

        if (title.length() > 100) {
            map.put("error_message", "Title length cannot be greater than 100");
            return map;
        }

        if (description == null || description.length() == 0) {
            description = "This user is lazy and left nothing~";
        }

        if (description.length() > 300) {
            map.put("error_message", "The length of the Bot description cannot be greater than 300");
            return map;
        }

        if (content == null || content.length() == 0) {
            map.put("error_message", "Content cannot be empty");
            return map;
        }

        if (content.length() > 10000) {
            map.put("error_message", "Content length cannot exceed 10000");
            return map;
        }
        Bot bot = botMapper.selectById(bot_id);
        if (bot == null) {
            map.put("error_message", "Bot does not exist or has been deleted");
            return map;
        }
        if (!bot.getUserId().equals(user.getId())) {
            map.put("error.message", "No permission to update bot");
            return map;
        }
        Bot new_bot = new Bot(
                bot.getId(),
                user.getId(),
                title,
                description,
                content,
                bot.getRating(),
                bot.getCreatetime(),
                new Date()
        );
        botMapper.updateById(new_bot);
        map.put("error_message", "success");
        return map;
    }
}
