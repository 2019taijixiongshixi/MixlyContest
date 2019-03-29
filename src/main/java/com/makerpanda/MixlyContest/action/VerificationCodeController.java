package com.makerpanda.MixlyContest.action;

import com.makerpanda.MixlyContest.MailUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class VerificationCodeController {
    @ResponseBody
    @RequestMapping(value = "/getverifycode", method = RequestMethod.POST)
    public void handlePostRequest(@RequestParam("email") String Email){
        MailUtil.getVerificationCode(Email);
    }
}
