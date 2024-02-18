local stockKey = KEYS[1]
local username = ARGV[1]
local stockName = ARGV[2]
local currentStock = tonumber(redis.call('GET', stockKey))

if currentStock and currentStock > 0 then
    redis.call("DECR",stockKey)

    return 'success'
else
    return 'failure'
end