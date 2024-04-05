if type(events["svc.microphone"]) == "Event" then
    events["svc.microphone"] = function ()
        print("player is currently talking on mic")
    end
end
